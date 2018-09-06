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

SRCREV = "4d92d9f0b3d569ceb2699b52f8bd511d3a21bc82"
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
  https://cdn.kernel.org/pub/linux/kernel/v4.x/incr/patch-4.18.5-6.xz;name=patch_6;apply=yes \
"
SRC_URI[patch_6.md5sum] = "74dbb61614581cf8da08be1185c46c25"
SRC_URI[patch_6.sha256sum] = "ec461fd5bb55f57dafb055fc8809cc2487302a0cf3e8c90d615f589949ea0bd8"
S = "${WORKDIR}/git"
