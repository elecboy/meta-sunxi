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

LINUX_VERSION ?= "4.14.25"
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
	file://0013-enable-naopi-neo-emac.patch \
	file://0014-enable-naopi-neo-usb-otg.patch \
	file://0015-fix-pcf8563-alarm-enable.patch \
	file://0016-add-pcf8563-rtc-to-nanopi-neo-air.patch \
	file://0017-enable-usb-0-1-on-nanopi-core.patch \
	https://cdn.kernel.org/pub/linux/kernel/v4.x/patch-${LINUX_VERSION}.xz;name=patch;apply=yes \
	"
SRC_URI[patch.md5sum] = "e6256bb4c6db2a9340a72bc81f235f49"
SRC_URI[patch.sha256sum] = "a4d4dbbe1b8c21e963e470d80efb596c070c58a4a5ef8d21ed459cb8e29e3b26"

S = "${WORKDIR}/git"
