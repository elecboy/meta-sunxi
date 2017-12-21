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

LINUX_VERSION ?= "4.14.8"
PV = "${LINUX_VERSION}+git${SRCPV}"

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

SRCREV = "cb31337027aaf606dc77cd423dc54197bb5ed16c"
SRC_URI = "git://github.com/megous/linux.git;protocol=git;branch=orange-pi-4.14 \
	file://defconfig \
	file://0001-add-usb2-usb3-to-neo-air.patch \
	file://0002-Enable-AP6212-WiFi-and-eMMc.patch \
	file://0003-enable-neo-air-i2c0.patch \
	file://0004-add-cpufreq-to-neo-air.patch \
	file://0005-add-ds3231-rtc-to-nanopi-neo-air.patch \
	file://0007-add-rx8010-rtc-to-nanopi-neo-air.patch \
	file://0008-fix-rx8010-rtc-wakeup.patch \
	file://0009-RX8010-RESV31-fix.patch \
	file://0010-RX8010-YEAR-duplicate-define.patch \
        file://0011-RX8010-reset-err-variable-to-account.patch \
	file://0012-enable-neo-air-uart1.patch \
	https://cdn.kernel.org/pub/linux/kernel/v4.x/patch-${LINUX_VERSION}.xz;name=patch;apply=yes \
	"
SRC_URI[patch.md5sum] = "e4a4d2abd61516d4eaf4789ca5e113ff"
SRC_URI[patch.sha256sum] = "42eaed731b716244514b765c199e8f675d79287d7630e5c2911053ad52a1fa0a"

S = "${WORKDIR}/git"
