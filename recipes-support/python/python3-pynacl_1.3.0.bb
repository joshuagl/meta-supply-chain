SUMMARY = "Python binding to the Networking and Cryptography (NaCl) library"
HOMEPAGE = "https://github.com/pyca/pynacl/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=7145f7cdd263359b62d342a02f005515 \
                    file://LICENSE;md5=8cc789b082b3d97e1ccc5261f8594d3f"

SRC_URI[sha256sum] = "0c6100edd16fefd1557da078c7a31e7b7d7a52ce39fdca2bec29d4f7b6e7600c"

PYPI_PACKAGE = "PyNaCl"

inherit pypi setuptools3

# Cribbed from https://github.com/MontaVista-OpenSourceTechnology/meta-qa/blob/master/meta-qa-framework/recipes-python/python/python-pynacl_1.1.2.bb
do_compile_prepend () {
	sed -i -e 's:configure, "--dis:configure, "--host=${TARGET_SYS}", "--dis:g' \
	-e 's:.*make.*check.*:#&:g' \
	${S}/setup.py

}

DEPENDS = "libsodium-native python3-cffi-native"
RDEPENDS_${PN} = "libsodium"
