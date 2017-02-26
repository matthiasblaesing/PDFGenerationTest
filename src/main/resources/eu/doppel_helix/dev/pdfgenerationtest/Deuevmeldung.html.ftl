[#ftl strip_whitespace="true" output_format="XHTML"]
<html>
    <head>
        <style type="text/css">
            * {
                font-family: sans-serif;
            }
            
            div.footer {
                display: block; 
                text-align: left;
                font-size: 10pt;
                position: running(footer);
            }
            
            @page {
                @bottom-left {
                    content: element(footer) 
                }
                
                size: A4;
                margin: 2cm;
            }
            
            div.sender {
                position: absolute;
                top: 0cm;
                left: 0cm;
                width: 100%;
                font-size: 8pt;
            }
            
            div.fensterreihe {
                position: absolute;
                top: 4cm;
                left: 0cm;
                width: 100%;
            }
            
            div.fensterreihe div.sender {
                position: relative;
                font-size: 8pt;
            }
            
            div.fensterreihe div.empfaenger {
                font-size: 10pt;
                font-weight: bold;
            }
            
            div.fensterreihe div.empfaenger table.zusatzdaten {
                position: absolute;
                top: 0ex;
                right: 0ex;
            }
            
            div.fensterreihe div.empfaenger table.zusatzdaten td, div.fensterreihe div.empfaenger table.zusatzdaten th {
                padding: 0ex;
            }
            
            div.fensterreihe div.empfaenger table.zusatzdaten tr td:last-child {
                text-align: right;
                width: 18ex;
            }
            
            div.betreff {
                position: absolute;
                top: 8cm;
                left: 0cm;
                width: 100%;
                font-size: 14pt;
                font-weight: bold;
            }
            
            div.einleitung {
                position: absolute;
                top: 10cm;
                left: 0cm;
                width: 100%;
                font-size: 10pt;
            }
            
            div.daten {
                position: absolute;
                top: 12cm;
                left: 0cm;
                width: 100%;
                font-size: 10pt;
            }
            
            div.rahmen {
                border: 1px solid black;
                padding: 0.25cm;
            }
            
            div.daten table {
                margin-top: 0.25cm;
            }
            
            div.daten table tr th {
                width: 6cm;
            }
            
            div.daten div.info, div.daten table.group1 {
                font-weight: bold;
            }

            div.daten table.group2 th, div.daten table.group3 th {
                font-weight: normal;
            }
        </style>
    </head>
    <body>
        <div class="sender">
            <div class="senderName1">${data.firmaName1}</div>
            <div class="senderName2">${data.firmaName2}</div>
            <div class="senderStrasse senderHausnummer">${data.firmaStrasse} ${data.firmaHausnummer}</div>
            <div class="senderPLZ senderOrt">${data.firmaPLZ} ${data.firmaOrt}</div>
        </div>
        
        <div class="fensterreihe">
            <div class="sender">${data.firmaName1}</div>
            <div class="empfaenger">
                <div class="empfaengerAnrede">${data.maAnrede}</div>
                <div class="empfaengerVorname empfaengerNachname">${data.maVorname} ${data.maNachname}</div>
                <div class="empfaengerStrasse empfaengerHausnummer">${data.maStrasse} ${data.maHausnummer}</div>
                <div class="empfaengerPLZ empfaengerOrt">${data.maPLZ} ${data.maOrt}</div>
                <table class="zusatzdaten">
                    <tr><th>Personal-Nr.</th><td>${data.maPersonalnummer}</td></tr>
                    <tr><th>Versicherungs-Nr.</th><td>${data.maVersicherungsnummer}</td></tr>
                </table>
            </div>
        </div>
        
        <div class="betreff">Meldebescheinigung zur Sozialversicherung</div>
        
        <div class="einleitung">
            <p>Bescheinigung nach §25 DEÜV.</p>
            <p>Die folgenden Angaben wurden den Sozialversicherungsträgern übermittelt.</p>
        </div>
        
        <div class="daten">
            <div class="rahmen">
                <div class="info">Jahresmeldung vom ${data.zeitraumVon?string["dd.MM.yyyy"]} bis ${data.zeitraumBis?string["dd.MM.yyyy"]}</div>
                <table class="group1">
                    <tr><th>Grund der Abgabe</th><td>${data.grundDerAbgabeCode}</td></tr>
                    <tr><th>Stornierung</th><td>${data.stornierung?string("Ja", "Nein")}</td></tr>
                    <tr><th>übermittelt am</th><td>${data.uebermitteltAm?string["dd.MM.yyyy"]}</td></tr>
                </table>
                <table class="group2">
                    <tr><th>Betr.-Nr. Arbeitgeber</th><td>${data.firmaBetriebsnummer?string["00000000"]}</td><td></td></tr>
                    <tr><th>Betr.-Nr. Einzugsstelle</th><td>${data.einzugsstelleBetriebsnummer?string["00000000"]}</td><td>${data.einzugsstelleName}</td></tr>
                </table>
                <table class="group3">
                    <tr><th>Beitragsgruppe KV</th><td>${data.beitragsgruppeKVCode}</td><td>${data.beitragsgruppeKVName}</td></tr>
                    <tr><th>Beitragsgruppe RV</th><td>${data.beitragsgruppeRVCode}</td><td>${data.beitragsgruppeRVName}</td></tr>
                    <tr><th>Beitragsgruppe AV</th><td>${data.beitragsgruppeAVCode}</td><td>${data.beitragsgruppeAVName}</td></tr>
                    <tr><th>Beitragsgruppe PV</th><td>${data.beitragsgruppePVCode}</td><td>${data.beitragsgruppePVName}</td></tr>
                    <tr><th>Personengruppenschlüssel</th><td>${data.personengruppenschluesselCode}</td><td>${data.personengruppenschluesselName}</td></tr>
                    <tr><th>Staatsangehörigkeit</th><td>${data.staatsangehoerigkeitCode}</td><td>${data.staatsangehoerigkeitName}</td></tr>
                    <tr><th>Rechtskreis</th><td>${data.rechtskreisCode}</td><td>${data.rechtskreisName}</td></tr>
                    <tr><th>Mehrfachbeschäftigter</th><td>${data.mehrfachbeschaeftigterCode}</td><td>${data.mehrfachbeschaeftigterName}</td></tr>
                    <tr><th>Gleitzone</th><td>${data.gleitzoneCode}</td><td>${data.gleitzoneName}</td></tr>
                    <tr><th>Tätigkeitsschlüssel</th><td colspan="2">${data.taetigkeitsschluesselCode}</td></tr>
                    <tr><th>Entgelt in Euro</th><td colspan="2">${data.entgeltInEuro?string["000000"]}</td></tr>
                </table>
            </div>
        </div>
        
        <div class="footer">
            Bitte nehmen Sie diese Meldungen zu Ihren Unterlagen.
        </div>
    </body>
</html>
