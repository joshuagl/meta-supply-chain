SUMMARY = "Utility library for gitignore style pattern matching of file paths"
HOMEPAGE = "https://github.com/cpburnz/python-path-specification"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=6a8fd56c1f0a09e0b442c90a5737b286 \
                    file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

SRC_URI[sha256sum] = "54a5eab895d89f342b52ba2bffe70930ef9f8d96e398cccf530d21fa0516a873"

inherit pypi setuptools3

BBCLASSEXTEND = "native nativesdk"
