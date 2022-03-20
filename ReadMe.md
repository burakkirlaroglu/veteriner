Veteriner App

Tamamlananlar;

        * Hayvan tanıtımı ( tür, cins, isim, yaş, açıklama ) 
        * Hayvan Sahibi tanıtımı ( ad soyad, iletişim bilgileri, telefon,
        e-posta ) 
        * Hayvan adı ya da hayvan sahibi adı üzerinden aranabilmeli
        * Bir hayvan sahibine n adet hayvan tanımı yapılabilmeli
        * Var olan bir kayıt üzerinde değişiklik yapılabilmeli
        * Var olan kayıtlar incelebilmeli
        * Var olan bir kayıt silinebilmeli

* projede kullanılan paketleri HELP.md dosyasından görebilirsiniz.

Nasıl daha iyi olur ?
* Pet type ve genus alanları String olarak enum şeklinde alınmalı, bu şekilde kullanıcı hatasının önüne geçilebilir
* Genel olarak arayüz tasarımı kullanıcı dostu olmalı, proje stabil çalışmıyor.
* Owner'ın address alanı ayrı bir tabloya sahip olabilir. Bu sayede Owner'ın adres bilgileri daha ayrıntılı ve yönetilebilir olur.
* Validasyonlar eklenmeli. Kullanıcı hatasının önüne geçebilen önemli olaylardan biri.
* Genel olarak Exception handling yapılmalı server tarafında alınan hataların incelenebilmesi ve kullanıcının neyi yanlış yaptığının farkında olması açısından çok önemli
* Verilerin boş, null veya kesin dolu şeklinde gönderilmesiyle alakalı değerler belirlenmeli. Bu sayede modelin hareketleri çerçevelenmiş olup diğer taraflarda daha rahat hareket edilebilir. Olası senaryo hatalarının önüne geçilir.
* Veri tipleri gözden geçirilmeli. Bazı durumlar için Collections kullanılabilir mi bakılabilir.
* Routing düzeltilmeli.

Projeyi açmak için yapılması gerekenler;

* java 8 ile yazıldı.
* postgres version 14 kullanıldı. Projeyi ayağa kaldırmadan önce veteriner adlı db oluşturulmalı.
* dependencyler düzgün şekilde yüklendiyse eğer çalıştırılabilir.(version vs kontrol edilebilir.)

Endpoints
* index (bu kısım sadece ilk görüntüyü verir)

* pets/list
* pets/edit/id
* pets/update/id
* pets/add
* pets/find?search=name

* owner/add
* owner/list
* owner/edit/id
* owner/update/id


