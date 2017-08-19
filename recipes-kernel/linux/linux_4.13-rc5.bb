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
	
SRC_URI[md5sum] = "a694a893f7750c0c1dad9231210f2212"
SRC_URI[sha256sum] = "431c1aa80a6df79c33430a51d79caf6627a94317fba13f5ef80f34b5acb77877"

SRC_URI = "https://git.kernel.org/torvalds/t/linux-${PV}.tar.gz \
        file://defconfig \
        "
