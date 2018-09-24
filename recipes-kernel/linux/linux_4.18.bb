SECTION = "kernel"
DESCRIPTION = "Mainline Linux kernel"

inherit kernel

require linux.inc
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSES/preferred/GPL-2.0;md5=e6a75371ba4d16749254a51215d13f97"
COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i|sun8i)"

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

PV .= ""

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

SRCREV = "3dd13c3d8e72aa94dc5fa0c9521d36cc0c86047a"
SRC_URI = "git://github.com/megous/linux.git;protocol=git;branch=orange-pi-4.18 \
	file://defconfig \
  file://0001-add-usb2-usb3-to-nanopi-neo-air.patch \
  file://0002-enable-emmc-and-ap6212-bluetooth-uart3.patch \
  file://0003-enable-neo-air-i2c0.patch \
  file://0004-add-cpufreq-to-neo-air.patch \
  file://0005-add-ds3231-rtc-to-nano-pi-neo-air.patch \
  file://0006-add-rx8010-rtc-to-nanopi-neo-air.patch \
  file://0007-fix-rx8010-rtc-wakeup.patch \
  file://0008-rx8010-reset-err-variable-to-account.patch \
  file://0009-enable-neo-air-uart1.patch \
  file://0010-enable-nanopi-neo-air-emac.patch \
  file://0011-add-pcf8563-rtc-to-nanopi-neo-air.patch \
  file://0012-enable-nanopi-neo-air-usb-otg.patch \
  file://0013-enable-usb-0-1-on-nanopi-neo-core.patch \
  https://cdn.kernel.org/pub/linux/kernel/v4.x/incr/patch-4.18.7-8.xz;name=patch_8;apply=yes \
  https://cdn.kernel.org/pub/linux/kernel/v4.x/incr/patch-4.18.8-9.xz;name=patch_9;apply=yes \
"

SRC_URI[patch_8.md5sum] = "c13dacd146d42e3d907501859aebec3c"
SRC_URI[patch_8.sha256sum] = "d11c9c0f2283fb1a879627f56ac2f2b1249d8ce6f0343f718f790766b51b2513"
SRC_URI[patch_9.md5sum] = "bed7ee895b37bb07e1b6ad252473ff45"
SRC_URI[patch_9.sha256sum] = "82ab34d06824537448f81433fe94e28a3c53dd51b8a1763f84a580b1cd175c64"

S = "${WORKDIR}/git"
