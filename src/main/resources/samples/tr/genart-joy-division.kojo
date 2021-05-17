// Esin kaynağı https://generativeartistry.com/tutorials/joy-division/

// Her çalıştırmada farklı bir manzarayla karşılaşırız
kojoVarsayılanİkinciBakışaçısınıKur()
silVeSakla()
artalanıKur(Renk(60, 63, 65))
val ta = tuvalAlanı
val n = 22
val yatayAdım = ta.eni / (n + 1) / 2
val dikeyAdım = ta.boyu / (n + 1)

case class Nokta(x: Kesir, y: Kesir)
// Bir sıra dağ nasıl tanımlanır. Her bir x koordinatı için y koordinatını 
// yani dağın o noktadaki değerini belirleyerek.
// EğikÇizgi sınıfıyla bu iş tamam. Her bir EğikÇizgi nesnesi bir sıradağı tanımlayacak.
case class EğikÇizgi(noktalar: Yöney[Nokta]) // Yöney sıralı bir Nokta kümesi tanımlıyor
// EğikÇizgi yerine SıraDağ adını verseydik daha iyi olur muydu?

// Sıra sıra sıra dağlar çizmek istiyoruz. Önce herbir sıradağını hesaplayıp kümeye koyalım
var çizgiler = Yöney.boş[EğikÇizgi] // bu da boş bir EğikÇizgi kümesi, yani sıra sıra sıra dağlar 
yineleİçin(rangeTo(ta.y, ta.y + ta.boyu - 5 * dikeyAdım, dikeyAdım)) { y =>
    var noktalar = Yöney.boş[Nokta] // boş Nokta kümesiyle başlayalım
    yineleİçin(rangeTo(ta.x, ta.x + ta.eni, yatayAdım)) { x =>
        val f = mutlakDeğer(x / ta.eni * 2) // 0 ile 1 arasına taşıdık
        val f1 = (1 - f) * (1 - f) * 150  // x küçüldükçe f1 büyüyör
        noktalar = noktalar :+ Nokta(x, y + rastgeleKesir(f1.toInt)) // toInt: Kesir'i Sayı'ya çevir
    }
    çizgiler = çizgiler :+ EğikÇizgi(noktalar)
}
// 
def çizgidenResime(eç: EğikÇizgi) =
    kalemBoyu(2) * kalemRengi(beyaz) * boyaRengi(Renk(57, 57, 57)) ->
        Resim.yoldan { yol =>
            val nler = eç.noktalar
            val ilkNokta = nler(0)
            yol.moveTo(ilkNokta.x, ilkNokta.y) // yol bu Noktayla başlıyor
            yineleİçin(1 to nler.length - 2) { i =>
                // bu noktayla bir sonraki noktanın arasındaki noktayı bulalım      
                val araX = (nler(i).x + nler(i + 1).x) / 2
                val araY = (nler(i).y + nler(i + 1).y) / 2
                // doğru yerine yumuşak eğri ile birleştirelim (quadTo metoduyla)
                yol.quadTo(nler(i).x, nler(i).y, araX, araY)
            }
            // son noktaya düz bir çizgiyle gidelim
            yol.lineTo(nler.last.x, nler.last.y)
        }
// .map metoduyla da yukarıda tanımladığımız işlevi kullanarak çizgilerden resimler
// türetip çizelim
çiz(çizgiler.reverse.map(çizgidenResime))
// Neden reverse (sıra dağların sırasını tersine çevirme) metodunu kullandık?
// Onu silip tekrar çalıştırmayı dene.
// Bilirsin elbet, öndeki sıra dağlar arkadaki sıra dağların daha yüksek zirvelerini  
// görmemizi engelleyemese de, daha alçak zirveleri görmemizi engeller.
// Onun için en yukarıdan başlıyoruz çizmeye, çünkü sonra çizdiklerimiz 
// önce çizdiklerimizin üstüne çiziliyor ve onları görmemizi kısmen engelliyor. 

