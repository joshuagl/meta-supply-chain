SUMMARY = "The Update Framework (TUF) helps developers maintain the security of a software update system, even against attackers that compromise the repository or signing keys."
HOMEPAGE = "https://theupdateframework.github.io/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;begineline=8;endline=8;md5=d5ba1aeeda69d1c62620765aeee89368"

SRC_URI[sha256sum] = "65d5f87a41830494bf585f8a5082618ab26015d156a67f23e37552419e427cf1"

inherit pypi setuptools3

RDEPENDS_${PN}_class-target = " \
    python3-asn1crypto \
    python3-certifi \
    python3-cffi \
    python3-chardet \
    python3-colorama \
    python3-cryptography \
    python3-iso8601 \
    python3-misc \
    python3-requests \
    python3-securesystemslib \
"

BBCLASSEXTEND = "native"
