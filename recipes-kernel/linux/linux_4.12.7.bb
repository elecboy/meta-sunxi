SECTION = "kernel"
DESCRIPTION = "Mainline Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i|sun8i)"

inherit kernel

require recipes-kernel/linux/linux-dtb.inc
require linux.inc

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

S = "${WORKDIR}/linux-${PV}"
	
SRC_URI[md5sum] = "245d1b4dc6e82669aac2c9e6a2dd82fe"
SRC_URI[sha256sum] = "7ec25c6eb5f2c6c4e0ef554600caa950cb18386334fd4af8ae97dced7981be93"

SRC_URI = "http://mirrors.163.com/kernel/linux/kernel/v4.x/linux-${PV}.tar.xz \
        file://defconfig \
        "
