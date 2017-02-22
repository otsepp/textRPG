
**textRPG**

TextRPG on tekstipohjainen roolipeli. Peli etenee erilaisten tilanteiden kautta, jotka ovat ilmaistu tekstillä, ja
joihin pelaaja vastaa annetuilla komennoilla. Tilanteita on esimerkiksi yhteenotto vihollisen kanssa tai saapuminen paikkaan, jossa täytyy valita
etenemissuunta.
Yhteenoton kautta pelaaja joutuu taisteluun vihollisen kanssa. Taistelut ovat vuoroittaisia, joissa omalla
vuorollaan pelaaja valitsee taistelukomennon.
Pelaajalla on kokoelma tavaroita, joita hän voi käyttää taistelun aikana. 

**Ohjelman rakenne, käyttöohjeet**
Game-luokka käsittelee jonossa olevia pelin tapahtumia. Tapahtumaan voi liittyä pelaajaolio tai yksi eri vihollisolioista. 
Tapahtumiin liittyy eri komentoja, joita ei ole piirretty kaavioon. Esimerkiksi BattleEvent-tapahtumaan liittyy Attack-komento, jolla pelaaja iskee vihollista. Komento palauttaa
listan viestejä, jotka Game-luokan avulla näytetään käyttäjälle käyttöliittymän kautta. Komennon palautusarvo-olio (GameEventReturnValues, ei merkitty kaavioon) palauttaa viestien lisäksi totuusarvon,
joka ilmaisee, että jatkuuko tapahtuma. Jos tapahtuma jatkuu, pelaaja voi valita yhden uusista komennoista, jos aikaisempi komento muutti niitä. 
Pelaaja voi taistelun aikana käyttää Usable-rajapinnan toteuttavia tavaroita. Pelaajan reppuun kuuluu myös tällä hetkellä käytössä oleva ase.

**Luokkakaavio**	
![Luokkakaavio](luokkakaavio.png)

**Sekvenssikaavio 1**
![sekvenssikaavio1](sekv1.png)

**Sekvenssikaavio 2**
![sekvenssikaavio1](sekv2.png)
