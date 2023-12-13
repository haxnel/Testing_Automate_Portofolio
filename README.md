# Automate Testing Website dan API

Pada repositor ini teradapat beberapa kode bagaimana cara untuk melakukan testing Website maupun API dengan menggunakan
Selenium dan Cucumber dengan basis bahasa pemrograman Java.

## Pengujian projek
Dalam projek ini, testing dilakukan dengan menggunakan website [SauceDemo](https://www.saucedemo.com/).

Pengetesan dilakukan dengan mengambil beberapa test, seperti:
* Testing API
  * GET
  * UPDATE
  * POST
  * DELETE
* Teting Web
  * Login
  * SignUp
  * CheckOut

Hasil report dapat dilihat [disini](https://haxnel.github.io/Testing_Automate_Portofolio/)

## Struktur Proyek (Project Structure)
| Folder       | Description                                                 |
|--------------|-------------------------------------------------------------|
| src          | Sumber kode pada projek ini                                 |
| reports      | Folder penyimpanan file report setelah melakukan pengetesan |
| test         | Unit tests untuk projek                                     |
| com.Automate | Tempat dimana meletakan semua logika pengetesan             |
| resource     | Deskripsi fitur dan schema dari yang diuji pada projek ini  |


## Setting

Anda dapat menjalankan projek ini dengan ketentuan:
* IDE (Disarankan Intellj / Vscode), namun dapat menggunakan yang lain sesuai favorit IDE Anda
* Java 17-19 SE
* Gradle

Berikut contoh custom task yang ada pada project ini:
```
...
def tags = (findProperty('tags') == null) ? 'not @exclude' : findProperty('tags') + ' and not @exclude' 
//Untuk mengambil keseluruhan tags

task webTest(){
    description ("Isi dengan kalimat anda")
    dependsOn assemble, compileTestJava
    doLast {
        javaexec {
            main = "io.cucumber.core.cli.Main"
            classpath = configurations.cucumberRuntime + sourceSets.main.output + sourceSets.test.output
            args = [
                    '--plugin', 'html:reports/WebTest_Report.html',
                    '--plugin', 'json:reports/cucumberWeb.json',
                    '--plugin', 'pretty',
                    '--glue', 'com.Automate',
                    '--tags', "@WebTest and not @exclude",
                    'src/test/resources'
            ]
        }
    }
}

task apiTest(){
    description ("Isi dengan kalimat anda")
    dependsOn assemble, compileTestJava
    doLast {
        javaexec {
            main = "io.cucumber.core.cli.Main"
            classpath = configurations.cucumberRuntime + sourceSets.main.output + sourceSets.test.output
            args = [
                    '--plugin', 'html:reports/APiTest_Report.html',
                    '--plugin', 'json:reports/cucumberAPI.json',
                    '--plugin', 'pretty',
                    '--glue', 'com.Automate',
                    '--tags', "@APITest and not @exclude",
                    'src/test/resources'
            ]
        }
    }
}

task AllTest(){
    description ("Isi dengan kalimat anda")
    dependsOn assemble, compileTestJava
    doLast {
        javaexec {
            main = "io.cucumber.core.cli.Main"
            classpath = configurations.cucumberRuntime + sourceSets.main.output + sourceSets.test.output
            args = [
                    '--plugin', 'html:reports/index.html',
                    '--plugin', 'json:reports/cucumberALL_Test.json',
                    '--plugin', 'pretty',
                    '--glue', 'com.Automate',
                    '--tags', "${tags}",
                    'src/test/resources'
            ]
        }
    }
}
...
*Note: 
- Pada plugin bisa terutama untuk report bisa di kostumisasi 
  sesuai keinginan anda untuk menaruh hasil report.
```
Anda juga dapa merubah kalimat pada task dengan kalimat anda sendiri seperti:
```
...
task "Kalimat anda sendiri" (){
    ...
    ...
}
...
*Note: Kurung tanda petik dihilangkan / dihapus
```
### Dependencies
Untuk pengaturan dependencies terdapat pada file build.gradle. Berikut untuk dependencies yang ada pada projek:
```
...
dependencies {
    testImplementation platform('org.junit:junit-bom:5.9.1')
    testImplementation 'org.junit.jupiter:junit-jupiter'
   
    testImplementation 'io.rest-assured:rest-assured:5.3.2'
    testImplementation group: 'io.rest-assured', name: 'json-path', version: '5.3.2'
    implementation group: 'org.seleniumhq.selenium', name: 'selenium-java', version: '4.16.1'
    implementation group: 'io.github.bonigarcia', name: 'webdrivermanager', version: '5.6.2'

    implementation 'io.cucumber:cucumber-java:7.14.0'
    testImplementation 'io.cucumber:cucumber-junit:7.14.0'

    implementation 'org.json:json:20231013'
    implementation 'io.rest-assured:json-schema-validator:5.3.2'

}
...
```
Disini dependencies sudah dipasangkan pada file build.gradle, namun jika anda mengalami kendala dependencies
anda dapat mengunjungi website [Maven Repository]("https://mvnrepository.com/") dan mengganti dependencies yang terjadi error.

#### Penting: Jangan lupa untuk load build.gradle agar dependencies terbaca.

## Cara Run Projek Local
Berikut cara untuk menjalankan projek keseluruhan di terminal menggunakan custom task yang telah dibuat:

```
./gradlew (nama custom task anda)
```
Pada projek ini, untuk custom task menggunakan task apiTest, webTest, dan AllTest, maka penulisan pada terminal seperti berikut:
```
./gradlew webTest apiTest AllTest

*Note: 
Ini akan menjalankan semua custom task, jika hanya ingin menjalankan satu task, dapat menghilangkan task yang tidak akan di running

./gradlew webTest
```
## Integrasi Github Action
Berikut contoh bagaimana integrasikan project dengan github action:

```
name: Automate Test Web and API Workflow

on:
  push:
    branches: [ "main" ]
  pull_request:
    branches: [ "main" ]
  workflow_dispatch:

jobs:
  #Menjalankan Tags @APITest Test
  run-automate-test-API:
    runs-on: ubuntu-latest

    steps:
    # Download Repo
    - uses: actions/checkout@v3
    
    # Setup Java
    - name: Set up JDK 11
      uses: actions/setup-java@v3
      with:
        java-version: '11'
        distribution: 'temurin'

    # Install Browser
    - name: Setup Chrome
      uses: browser-actions/setup-chrome@v1.4.0

    # Setup Gradlew
    - name: Setup Gradlew
      run: chmod +x gradlew

    # Setup Executing Test
    - name: Setup executing test
      run: ./gradlew apiTest
      
    #Archive artifact test
    - name: Archive artifact result Test
      uses: actions/upload-artifact@v3.1.3
      if: always()
      with: 
        name: Testing Reports
        path: reports

    # Deploy to GitHub Page
    - name: Deploy report test
      uses: peaceiris/actions-gh-pages@v3.9.3
      if: always()
      with:
        PERSONAL_TOKEN: ${{ secrets.GITHUB_TOKEN }}
        PUBLISH_DIR: reports

  #Menjalankan Tags @WebTest Test
  run-automate-test-Web:
    runs-on: ubuntu-latest

    steps:
      - name: Wait for other Job
        uses: NathanFirmo/wait-for-other-job@v1.1.1
        with:
          token: ${{ secrets.GITHUB_TOKEN }}
          job: 'run-automate-test-API'
          
    # Download Repo
      - uses: actions/checkout@v3
    
    # Setup Java
      - name: Set up JDK 11
        uses: actions/setup-java@v3
        with:
          java-version: '11'
          distribution: 'temurin'

    # Install Browser
      - name: Setup Chrome
        uses: browser-actions/setup-chrome@v1.4.0

    # Setup Gradlew
      - name: Setup Gradlew
        run: chmod +x gradlew

    # Setup Executing Test
      - name: Setup executing test
        run: ./gradlew webTest
      
    #Archive artifact test
      - name: Archive artifact result Test
        uses: actions/upload-artifact@v3.1.3
        if: always()
        with: 
          name: Testing Reports
          path: reports

    # Deploy to GitHub Page
      - name: Deploy report test
        uses: peaceiris/actions-gh-pages@v3.9.3
        if: always()
        with:
          PERSONAL_TOKEN: ${{ secrets.GITHUB_TOKEN }}
          PUBLISH_DIR: reports

  #Menjalankan keseluruhan Test
  run-automate-All-Test:
    runs-on: ubuntu-latest

    steps:
      - name: Wait for other Job
        uses: NathanFirmo/wait-for-other-job@v1.1.1
        with:
          token: ${{ secrets.GITHUB_TOKEN }}
          job: 'run-automate-test-Web'

      # Download Repo
      - uses: actions/checkout@v3

      # Setup Java
      - name: Set up JDK 11
        uses: actions/setup-java@v3
        with:
          java-version: '11'
          distribution: 'temurin'

      # Install Browser
      - name: Setup Chrome
        uses: browser-actions/setup-chrome@v1.4.0

      # Setup Gradlew
      - name: Setup Gradlew
        run: chmod +x gradlew

      # Setup Executing Test
      - name: Setup executing test
        run: ./gradlew AllTest

      #Archive artifact test
      - name: Archive artifact result Test
        uses: actions/upload-artifact@v3.1.3
        if: always()
        with:
          name: Testing Reports
          path: reports

      # Deploy to GitHub Page
      - name: Deploy report test
        uses: peaceiris/actions-gh-pages@v3.9.3
        if: always()
        with:
          PERSONAL_TOKEN: ${{ secrets.GITHUB_TOKEN }}
          PUBLISH_DIR: reports
          
*Note:
Disini melakukan 3 kali running Jobs
```
Jika anda hanya ingin salah satu dijalankan, maka anda hanya harus menghapus job tidak dijalankan.
Dan pada Workflow tersebut yang tersimpan di branch github hanya report job yang terakhir dijalankan.

*Note: Untuk artifact tetap dapat untuk di download

Namun harus mengganti terlebih dahulu pada ``build.gradle`` pada bagian plugin reports, terutama pada
file html yang harus bernama ``index.html``, karena jika anda ingin mem-publish report tersebut 
secara public anda harus mempunyai file bernama``index.html``

*Note: Hanya untuk kasus ini
***

Untuk dokumentasi Selenium dapat dilihat [disini](https://www.selenium.dev/documentation/)

Untuk dokumentasi Cucumber dapat dilihat [disini](https://cucumber.io/docs/cucumber/)

Untuk download Java versi 17 - 19 [disini](https://jdk.java.net/archive/)

Untuk download Gradle [disini](https://gradle.org/)