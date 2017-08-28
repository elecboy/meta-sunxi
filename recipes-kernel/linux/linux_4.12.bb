SECTION = "kernel"
DESCRIPTION = "Mainline Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i|sun8i)"

LINUX_VERSION ?= "4.12.9"
PE = "1"
PV = "${LINUX_VERSION}+git${SRCPV}"

inherit kernel

require recipes-kernel/linux/linux-dtb.inc
require linux.inc

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

SRCREV = "ef79e7bb67c80f0b20a8327692f590a54568eda5"
SRC_URI = "git://github.com/raspberrypi/linux.git;protocol=git;branch=rpi-4.12.y \
        file://defconfig \
        file://0001-add-usb2-usb3-to-neo-air.patch \
	file://0002-Enable-AP6212-WiFi-and-eMMc.patch \

UDEV_GE_141 ?= "1"
	"
# Set programmatically some variables during recipe parsing
# See http://www.yoctoproject.org/docs/current/bitbake-user-manual/bitbake-user-manual.html#anonymous-python-funct\
ions
python __anonymous () {
    kerneltype = d.getVar('KERNEL_IMAGETYPE')
    kerneldt = get_dts(d, d.getVar('LINUX_VERSION'))
    d.setVar("KERNEL_DEVICETREE", kerneldt)
}