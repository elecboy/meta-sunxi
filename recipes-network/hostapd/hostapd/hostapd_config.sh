#!/bin/sh
if [ -n "/sys/devices/platform/soc/1c10000.mmc/mmc_host/mmc1/mmc1:0001/" ]; then
    mac=`ifconfig wlan0| grep HWaddr | awk -F" " '{print $5}'`
else
    mac=`ifconfig eth0| grep HWaddr | awk -F" " '{print $5}'`
fi
ap_last_name=`echo $mac|awk -F: '{print $5$6}'`
sed  -i -e "s,0a55,${ap_last_name},g" /etc/hostapd.conf
