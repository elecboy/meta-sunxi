SECTION = "kernel"
DESCRIPTION = "Mainline Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i)"

inherit kernel

require recipes-kernel/linux/linux-dtb.inc
require linux.inc

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

S = "${WORKDIR}/linux-${PV}"
	
SRC_URI[md5sum] = "78129a98d1b8e42e52923ff75919a3ed"
SRC_URI[sha256sum] = "01ca0808f1e1933b2705a47b9a67ff1786839ae08c1ccbad3806e74425fe937b"

SRC_URI = "http://mirrors.163.com/kernel/linux/kernel/v4.x/linux-${PV}.tar.xz \
        file://defconfig \
        "
