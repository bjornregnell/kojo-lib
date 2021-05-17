// Bu örnek şu kaynaktan:
//     http://lalitpant.blogspot.in/2012/05/recursive-drawing-with-kojo.html
// Bu sefer Kojo'nun zengin Resim dilini (Pictures API) kullanalım

val büyüklük = 100
def resim = Resim {
    yinele(4) {
        ileri(büyüklük)
        sağ()
    }
}

def gövde = büyüt(0.13, 1) * kalemRengi(renksiz) * boyaRengi(siyah) -> resim

sil()
artalanıKur(Renk(255, 170, 29))
gizle()

def çizim(n: Sayı): Resim = {
    if (n <= 1)
        gövde
    else
        Resim.dizi(
            gövde,
            götür(0, büyüklük - 5) * aydınlık(0.05) -> Resim.dizi(
                döndür(25.0) * büyüt(0.72) -> çizim(n - 1),
                döndür(-50.0) * büyüt(0.55) -> çizim(n - 1))
        )
}

// 10 yerine daha küçük sayıları deneyerek nasıl çalıştığını görebilirsin 
çiz(götür(0, -100) -> çizim(10))
