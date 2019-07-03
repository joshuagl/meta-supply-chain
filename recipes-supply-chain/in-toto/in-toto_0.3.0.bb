SUMMARY = "in-toto is a framework to protect supply chain integrity"
HOMEPAGE = "https://in-toto.io/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=c2d9643b4523fdf462545aeb1356ad23"

SRC_URI[sha256sum] = "94a48896d41cfd57235a0152af401f010e9c5720f44a6c841cbc11e8d7c3a8a1"

inherit pypi setuptools3

SRC_URI += "file://0001-setup-make-pynacl-optional.patch"

RDEPENDS_${PN}_class-target = " \
    python3-attrs \
    python3-dateutil \
    python3-iso8601 \
    python3-pathspec \
    python3-securesystemslib \
"

BBCLASSEXTEND = "native"
