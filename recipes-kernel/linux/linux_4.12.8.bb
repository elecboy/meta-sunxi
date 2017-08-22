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
	
SRC_URI[md5sum] = "21b156026b5e9810e77c04f07c6b6cf3"
SRC_URI[sha256sum] = "d1b78c5ba88b6216bcd2e45cf567ebaff5cb2c8c7c6b73e1d8354dace98b9b7c"

SRC_URI = "http://mirrors.163.com/kernel/linux/kernel/v4.x/linux-${PV}.tar.xz \
        file://defconfig \
        file://0001-add-usb2-usb3-to-neo-air.patch \
	file://0002-Enable-AP6212-WiFi-and-eMMc.patch \
	"
