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

LINUX_VERSION ?= "4.13.6"
PV = "${LINUX_VERSION}+git${SRCPV}"

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

SRCREV = "c173fe35989ed23e9f14379550a056969ef6140c"
SRC_URI = "git://github.com/megous/linux.git;protocol=git;branch=orange-pi-4.13 \
	file://defconfig \
	file://0001-add-usb2-usb3-to-neo-air.patch \
	file://0002-Enable-AP6212-WiFi-and-eMMc.patch \
	file://0003-enable-neo-air-i2c0.patch \
	file://0004-add-cpufreq-to-neo-air.patch \
	file://0005-add-ds3231-rtc-to-nanopi-neo-air.patch \
	file://0006-add-power-ctrl.patch \
	https://cdn.kernel.org/pub/linux/kernel/v4.x/patch-4.13.6.xz;name=patch;apply=yes \
	"
SRC_URI[patch.md5sum] = "99857b5295fd8952fcd9f21950de5676"
SRC_URI[patch.sha256sum] = "12d897b7f547c7d03a81be690b3dc0e0e5b9becfbd63e3dbf9f7258db861ddfb"

S = "${WORKDIR}/git"


