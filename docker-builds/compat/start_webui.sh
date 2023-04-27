#!/bin/bash

if [[ ! -z $WEBAPI_URL ]]; then
    sed -i 's,http\:\/\/MYDOCKERHOST\:PORT,'$WEBAPI_URL',g' /opt/metasfresh-webui-frontend/dist/config.js
<<<<<<< HEAD
    sed -i 's,http\:\/\/MYDOCKERHOST\:PORT,'$WEBAPI_URL',g' /opt/metasfresh-webui-frontend/dist/mobile/config.js
=======
#    sed -i 's,http\:\/\/MYDOCKERHOST\:PORT,'$WEBAPI_URL',g' /opt/metasfresh-webui-frontend/dist/mobile/config.js
>>>>>>> 9ca46724894 (Revert "Revert "Merge remote-tracking branch 'origin/mad_orange_uat' into mad_orange_hotfix"" (#15192))
fi

if [[ -f "/etc/apache2/certs/fullchain.pem" ]] && [[ -f "/etc/apache2/certs/privkey.pem" ]]; then
        sed -i 's/\bhttp\b/https/g' /opt/metasfresh-webui-frontend/dist/config.js
        a2ensite metasfresh_webui_ssl.conf
        echo "[METASFRESH] Activated SSL!"
else
        sed -i 's/\https\b/http/g' /opt/metasfresh-webui-frontend/dist/config.js
        a2ensite metasfresh_webui.conf
        a2dissite metasfresh_webui_ssl.conf
        echo "[METASFRESH] Runnning Non-SSL!"
fi

/usr/sbin/apache2ctl -DFOREGROUND