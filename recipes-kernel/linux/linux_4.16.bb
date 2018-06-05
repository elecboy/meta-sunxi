SECTION = "kernel"
DESCRIPTION = "Mainline Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i|sun8i)"

inherit kernel

require linux.inc

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

LINUX_VERSION ?= "4.16.13"
PV = "${LINUX_VERSION}+git${SRCPV}"

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

SRCREV = "021dbd3eab6b3eee613cabae3a9c5cb89ac4cf8d"
SRC_URI = "git://github.com/megous/linux.git;protocol=git;branch=orange-pi-4.16 \
	file://defconfig \
	file://0001-add-usb2-usb3-to-neo-air.patch \
	file://0002-Enable-AP6212-WiFi-and-eMMc.patch \
	file://0003-enable-neo-air-i2c0.patch \
	file://0004-add-cpufreq-to-neo-air.patch \
	file://0005-add-ds3231-rtc-to-nanopi-neo-air.patch \
	file://0007-add-rx8010-rtc-to-nanopi-neo-air.patch \
	file://0008-fix-rx8010-rtc-wakeup.patch \
	file://0011-RX8010-reset-err-variable-to-account.patch \
	file://0012-enable-neo-air-uart1.patch \
	file://0013-enable-naopi-neo-emac.patch \
	file://0014-enable-naopi-neo-usb-otg.patch \
	file://0016-add-pcf8563-rtc-to-nanopi-neo-air.patch \
	file://0017-enable-usb-0-1-on-nanopi-core.patch \
	https://cdn.kernel.org/pub/linux/kernel/v4.x/incr/patch-4.16.10-11.xz;name=patch_11;apply=yes \
	https://cdn.kernel.org/pub/linux/kernel/v4.x/incr/patch-4.16.11-12.xz;name=patch_12;apply=yes \
  https://cdn.kernel.org/pub/linux/kernel/v4.x/incr/patch-4.16.12-13.xz;name=patch_13;apply=yes \
  https://cdn.kernel.org/pub/linux/kernel/v4.x/incr/patch-4.16.13-14.xz;name=patch_14;apply=yes \
	"
SRC_URI[patch_11.md5sum] = "d15e27bdd9744e6ec24660d4357ed3e7"
SRC_URI[patch_11.sha256sum] = "3d90d995797c68bf8f6b4f45b1955ae6f23b3ed9aed695bddcb40549714f288d"
SRC_URI[patch_12.md5sum] = "a1717ba945c65cf1d4e274347b1f78fe"
SRC_URI[patch_12.sha256sum] = "2ccb2f9b20a3b140268bfc171f5f7360d533b5d6da6cb114a07d411f4d1d39d8"
SRC_URI[patch_13.md5sum] = "1bba7113c49ca71f6cb9b02b4790f6c3"
SRC_URI[patch_13.sha256sum] = "e2a317e65ffaf04762887f28c056c3cc5b7843c7d749f65932c5e44064ff84f8"
SRC_URI[patch_14.md5sum] = "b40f3940fec7be0fd19a691d116ac3f1"
SRC_URI[patch_14.sha256sum] = "4a568a147fb6b2eca9619e7bed85b8d6a63f88d54ba5dfc3ea32832c8f5747be"

S = "${WORKDIR}/git"
