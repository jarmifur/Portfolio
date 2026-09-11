#!/usr/bin/env python3
import socket
import argparse
from concurrent.futures import ThreadPoolExecutor

parser = argparse.ArgumentParser(description="Simple TCP port scanner")
parser.add_argument("target", help="IP address to scan")
parser.add_argument("--ports", help="Port range to scan", default="1-1024")
args = parser.parse_args()
target = args.target
try:
    start, end = map(int, args.ports.split("-"))
except ValueError:
    parser.error("Ports must be in the format START-END")
if start < 1 or end > 65535:
    parser.error("Ports must be between 1 and 65535")
if start > end:
    parser.error("Starting port must be less than or equal to ending port")

def detect_service(banner):
    banner_lower = banner.lower()

    if "ssh" in banner_lower:
        return "SSH"
    elif "ftp" in banner_lower:
        return "FTP"
    elif "smtp" in banner_lower:
        return "SMTP"
    elif "http" in banner_lower:
        return "HTTP"
    elif "imap" in banner_lower:
        return "IMAP"
    elif "pop3" in banner_lower:
        return "POP3"
    else:
        return "Unknown"

def grab_banner(sock, port):
    try:
        if port in [80, 443, 8000]:
            sock.send(b"HEAD / HTTP/1.0\r\n\r\n")
        else:
            sock.send(b"\r\n")

        banner = sock.recv(1024)
        return banner.decode(errors="ignore").strip()
    except (socket.timeout, OSError):
        return ""

def scan_port(port):

    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    sock.settimeout(0.1)

    result = sock.connect_ex((target, port))

    if result == 0:
        banner = grab_banner(sock, port)
        service = detect_service(banner)

        print(f"{port}/tcp OPEN {service}")
        if banner:
            lines = banner.splitlines()
            print(f"    {lines[0]}")

            for line in lines:
                if line.lower().startswith("server"):
                    server = line.split(":", 1)[1].strip()
                    print(f"    Server: {server}")
    sock.close()

with ThreadPoolExecutor(max_workers=100) as executor:
    executor.map(scan_port, range(start, end + 1))