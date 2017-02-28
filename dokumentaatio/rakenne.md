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