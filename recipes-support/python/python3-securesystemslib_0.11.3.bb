SUMMARY = "A library that provides cryptographic and general-purpose routines \
           for Secure Systems Lab projects at NYU"
HOMEPAGE = "https://github.com/secure-systems-lab/securesystemslib"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=23f9ad5cad3d8cc0336e2a5d8a87e1fa"

SRC_URI[sha256sum] = "cbd1f7f1af2f2921be33b9fd17384705f5f4147d3a8b5d95b33ec3ce2213f176"

inherit pypi setuptools3

# TODO: add python3-pynacl, it gives faster ed25519 operations with better
# side-channel protections
RDEPENDS_${PN}_class-target = " \
    python3-colorama \
    python3-cryptography \
    python3-json \
"

BBCLASSEXTEND = "native"
