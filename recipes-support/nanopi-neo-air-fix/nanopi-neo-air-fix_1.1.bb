SUMMARY = "Nanopi-NEO-Air service func fix"
DESCRIPTION = "Mtsports nanopi-neo-air some fix service."
SECTION = "base"
PR = "r1"

inherit systemd

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://GPL-2;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "\
    file://nanopi-neo-air-rtc.service \
    file://nanopi-neo-air-cpufreq-wlan.service \
    file://GPL-2 \
"
SRC_URI[md5sum] = "f426102c3355fbf73f94f320081e471f"

S = "${WORKDIR}"

SYSTEMD_AUTO_ENABLE_${PN} = "enable"

do_install() {
    install -m 0644 -D ${WORKDIR}/nanopi-neo-air-fix.service ${D}${systemd_unitdir}/system/nanopi-neo-air-rtc.service
    install -m 0644 -D ${WORKDIR}/nanopi-neo-air-fix.service ${D}${systemd_unitdir}/system/nanopi-neo-air-cpufreq-wlan.service
    sed -i -e 's,@SBINDIR@,${sbindir},g' -e 's,@SYSCONFDIR@,${sysconfdir},g' ${D}${systemd_unitdir}/system/nanopi-neo-air-rtc.service
    sed -i -e 's,@SBINDIR@,${sbindir},g' -e 's,@SYSCONFDIR@,${sysconfdir},g' ${D}${systemd_unitdir}/system/nanopi-neo-air-cpufreq-wlan.service
}

SYSTEMD_SERVICE_${PN} = "nanopi-neo-air-rtc.service nanopi-neo-air-cpufreq-wlan.service"

PACKAGES = "${PN}"
FILES_${PN} = "/"
