
**textRPG**

TextRPG on tekstipohjainen roolipeli. Peli etenee erilaisten tilanteiden kautta, jotka ovat ilmaistu tekstill�, ja
joihin pelaaja vastaa annetuilla komennoilla. Tilanteita on esimerkiksi yhteenotto vihollisen kanssa tai saapuminen paikkaan, jossa t�ytyy valita
etenemissuunta.
Yhteenoton kautta pelaaja joutuu taisteluun vihollisen kanssa. Taistelut ovat vuoroittaisia, joissa omalla
vuorollaan pelaaja valitsee taistelukomennon.
Pelaajalla on kokoelma tavaroita, joita h�n voi k�ytt�� taistelun aikana. 

**Ohjelman rakenne, k�ytt�ohjeet**
Game-luokka k�sittelee jonossa olevia pelin tapahtumia. Tapahtumaan voi liitty� pelaajaolio tai yksi eri vihollisolioista. 
Tapahtumiin liittyy eri komentoja, joita ei ole piirretty kaavioon. Esimerkiksi BattleEvent-tapahtumaan liittyy Attack-komento, jolla pelaaja iskee vihollista. Komento palauttaa
listan viestej�, jotka Game-luokan avulla n�ytet��n k�ytt�j�lle k�ytt�liittym�n kautta. Komennon palautusarvo-olio (GameEventReturnValues, ei merkitty kaavioon) palauttaa viestien lis�ksi totuusarvon,
joka ilmaisee, ett� jatkuuko tapahtuma. Jos tapahtuma jatkuu, pelaaja voi valita yhden uusista komennoista, jos aikaisempi komento muutti niit�. 
Pelaaja voi taistelun aikana k�ytt�� Usable-rajapinnan toteuttavia tavaroita. Pelaajan reppuun kuuluu my�s t�ll� hetkell� k�yt�ss� oleva ase.

**Luokkakaavio**	
![Luokkakaavio](luokkakaavio.png)

**Sekvenssikaavio 1**
![sekvenssikaavio1](sekv1.png)

**Sekvenssikaavio 2**
![sekvenssikaavio1](sekv2.png)
