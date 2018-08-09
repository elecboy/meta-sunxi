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

SRCREV = "78970c0ba410ca28b9722ce873707d09581d4ec3"
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
  https://cdn.kernel.org/pub/linux/kernel/v4.x/incr/patch-4.17.10-11.xz;name=patch_11;apply=yes \
  https://cdn.kernel.org/pub/linux/kernel/v4.x/incr/patch-4.17.11-12.xz;name=patch_12;apply=yes \
  https://cdn.kernel.org/pub/linux/kernel/v4.x/incr/patch-4.17.12-13.xz;name=patch_13;apply=yes \
  https://cdn.kernel.org/pub/linux/kernel/v4.x/incr/patch-4.17.13-14.xz;name=patch_14;apply=yes \
"

SRC_URI[patch_11.md5sum] = "6b414f93ba7824b301d2160c7306919a"
SRC_URI[patch_11.sha256sum] = "420cb72471250f9f0abefbde585fd9f3589471f96055edafd2942ce026154bce"
SRC_URI[patch_12.md5sum] = "ea2b944974296bc0157d7bf602ac9998"
SRC_URI[patch_12.sha256sum] = "4c31445315f1c0f2b429b533d2c334e0b4a8cc0a56313093eb0d05bd5466d4e7"
SRC_URI[patch_13.md5sum] = "1f292a1699eff55791263f54984bde24"
SRC_URI[patch_13.sha256sum] = "93102cbfbb87824755270ccfaf3e1a6bccbdb370305fe38abe123b5c0fc1886b"
SRC_URI[patch_14.md5sum] = "4246e4ce2875958b972672189453ee7c"
SRC_URI[patch_14.sha256sum] = "7cb05d2fc321e46394ae1b0c1e15b28ecd7fada050739e76021c8aa8ae058850"

S = "${WORKDIR}/git"
