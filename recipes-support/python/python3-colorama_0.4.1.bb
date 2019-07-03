SUMMARY = "Cross-platform colored terminal text."
HOMEPAGE = "https://github.com/tartley/colorama"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=9;endline=9;md5=e910b35b0ef4e1f665b9a75d6afb7709 \
                    file://LICENSE.txt;md5=b4936429a56a652b84c5c01280dcaa26"

SRC_URI[sha256sum] = "05eed71e2e327246ad6b38c540c4a3117230b19679b875190486ddd2d721422d"

inherit pypi setuptools3

BBCLASSEXTEND = "native nativesdk"
