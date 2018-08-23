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

PV .= ""

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

SRCREV = "0272f8ad39243169f0d18ec8c9bd4c628a5d84a0"
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
  https://cdn.kernel.org/pub/linux/kernel/v4.x/incr/patch-4.17.14-15.xz;name=patch_15;apply=yes \
  https://cdn.kernel.org/pub/linux/kernel/v4.x/incr/patch-4.17.15-16.xz;name=patch_16;apply=yes \
  https://cdn.kernel.org/pub/linux/kernel/v4.x/incr/patch-4.17.16-17.xz;name=patch_17;apply=yes \
  https://cdn.kernel.org/pub/linux/kernel/v4.x/incr/patch-4.17.17-18.xz;name=patch_18;apply=yes \
"

SRC_URI[patch_15.md5sum] = "17d19cf0885ce66fdf3d2ec9f96f21e0"
SRC_URI[patch_15.sha256sum] = "4b516704a7a0cc3d297cbe76d6b85707094fdcdf3aa20fab2e514017dbe75e7f"
SRC_URI[patch_16.md5sum] = "b7919a9012d27b3886c0d439a6cf6c94"
SRC_URI[patch_16.sha256sum] = "f0bcc5e592a9fa01417a07e95d27c4e43ce8913441427b533b9f11aa75720b5f"
SRC_URI[patch_17.md5sum] = "a69ab631a963b2af83723fb4fda30de5"
SRC_URI[patch_17.sha256sum] = "461e6abe42d5b0155223cbf06388f3b8347dbac28c6f6e3b3a0596b90a56b6ff"
SRC_URI[patch_18.md5sum] = "63deb6b4813ae6e086530852ec649dfa"
SRC_URI[patch_18.sha256sum] = "f67f659f240d909f3cd2c8e946f9c5900265f89be4074ef8db3169b21f82cc25"

S = "${WORKDIR}/git"
