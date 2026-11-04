# FIT menjava naprave (Android)

Android aplikacija, ki v datoteki `.fit` (npr. iz Zwifta) zamenja napravo, s katero je bila aktivnost posneta,
na enak način kot https://www.fitfiletools.com/changer. Seznam naprav (479) in proizvajalcev (243) je enak kot na tej strani.
Vse se obdela na telefonu, brez interneta in brez pošiljanja datotek kamorkoli.

- Datoteke izbereš v aplikaciji ali jih vanjo **deliš / odpreš z** iz drugih aplikacij (upravitelj datotek, Dropbox …).
- Pretvorjene datoteke se shranijo v **Prenosi/FIT** (`Download/FIT`).
- Zahteva Android 10 ali novejši.

## Kako dobiti APK

### Možnost A: GitHub (brez nameščanja česarkoli)
1. Na github.com ustvari nov repozitorij in vanj naloži vsebino te mape (tudi skrito mapo `.github`).
2. Odpri zavihek **Actions**. Gradnja »Zgradi APK« se zažene sama (ali jo zaženi z **Run workflow**).
3. Po nekaj minutah odpri zaključen zagon in pod **Artifacts** prenesi `FIT-menjava-naprave-apk` (ZIP z APK-jem).
4. APK prenesi na telefon in ga namesti (dovoli »Namesti neznane aplikacije« za brskalnik / upravitelja datotek).

### Možnost B: Android Studio
1. Odpri mapo `FitMenjavaNaprave` v Android Studiu (File → Open).
2. Počakaj, da se Gradle sinhronizira, nato **Build → Build App Bundle(s) / APK(s) → Build APK(s)**.
3. APK je v `app/build/outputs/apk/debug/app-debug.apk`, ali pa telefon priključi in klikni ▶ Run.

## Struktura
- `app/src/main/assets/index.html` – celotna logika (branje/pisanje FIT, seznami naprav, vmesnik).
- `app/src/main/java/si/fitmenjava/MainActivity.java` – WebView ovoj: izbira datotek, shranjevanje v Prenose, sprejem deljenih datotek.

## Kaj se spremeni v datoteki
Sporočilo `file_id` (proizvajalec, izdelek, serijska številka; manjkajoča polja se dodajo) in glavni zapis `device_info`
(device_index 0). Vsi podatki aktivnosti ostanejo nespremenjeni; kontrolne vsote CRC se izračunajo na novo.
