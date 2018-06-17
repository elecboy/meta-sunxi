SECTION = "kernel"
DESCRIPTION = "Mainline Linux kernel"

inherit kernel

require linux.inc
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSES/preferred/GPL-2.0;md5=74274e8a218423e49eefdea80bc55038"
COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i|sun8i)"

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

LINUX_VERSION ?= "4.17.2"
#PV = "${LINUX_VERSION}+git${SRCPV}"
PV .= ""

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

SRCREV = "a93307e4a443fb50b85155567b467216ee59fd11"
SRC_URI = "git://github.com/megous/linux.git;protocol=git;branch=orange-pi-4.17 \
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
"

#SRC_URI[patch_1.md5sum] = "8f430fc5bf2fd5a6ec5da8b4a08473d8"
#SRC_URI[patch_1.sha256sum] = "31f2f5309d99db632160538d43cf737166ae8b24c1b8091522ca1f9a804c25a1"

S = "${WORKDIR}/git"
