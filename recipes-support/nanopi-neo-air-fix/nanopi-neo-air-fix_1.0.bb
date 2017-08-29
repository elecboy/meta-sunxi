SUMMARY = "Nanopi-NEO-Air service func fix"
DESCRIPTION = "Mtsports nanopi-neo-air some fix service."
SECTION = "base"
PR = "r1"

inherit systemd

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://licenses/GPL-2;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "\
    file://nanopi-neo-air-fix.service \
    file://licenses/GPL-2 \
"
SRC_URI[md5sum] = "f426102c3355fbf73f94f320081e471f"

S = "${WORKDIR}"

SYSTEMD_AUTO_ENABLE_${PN} = "enable"

do_install() {
    install -m 0644 -D ${WORKDIR}/nanopi-neo-air-fix.service ${D}${systemd_unitdir}/system/nanopi-neo-air-fix.service
    sed -i -e 's,@SBINDIR@,${sbindir},g' -e 's,@SYSCONFDIR@,${sysconfdir},g' ${D}${systemd_unitdir}/system/nanopi-neo-air-fix.service
}

SYSTEMD_SERVICE_${PN} = "nanopi-neo-air-fix.service"

PACKAGES = "${PN}"
FILES_${PN} = "/"
