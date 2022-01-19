package h04_OneToMany;





import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H4_Fetch {

	public static void main(String[] args) {
		Configuration con = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(H1_Ogrenci.class).
				addAnnotatedClass(H2_Kitap.class);
		
		SessionFactory  sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		
		// id=111 olan ogrencinin tum kitaplarini listeleyelim.
//H1_Ogrenci	ogrenci = session.get(H1_Ogrenci.class, 111);
//		
//		for(H2_Kitap w: ogrenci.getKitapListesi()) {
//			System.out.println(w);
//		}
////		
//////		// id=1002 olan kitap'ın sahibinin bilgilerini listeleyelim.
//	H2_Kitap	kitap = session.get(H2_Kitap.class, 1002);
//		System.out.println(kitap.getOgrenci());
//	
////		// kitaplar ve ogrenciler tablolarindaki ortak olan ogrenci bilgilerini listeleyiniz.
//		String hql1 = "SELECT o.ogrAd, k.isim "
//				+ "FROM H1_Ogrenci o INNER JOIN H2_Kitap k "
//				+ "ON o.ogrId = k.ogrenci";
//		
//		 List <Object[]> sonucListesi = session.createQuery(hql1).getResultList();
//		 sonucListesi.stream().forEach((x) -> System.out.println(Arrays.toString(x)));
//		
//		//--------------------------------------------------------------------------
//		//                              SILME ISLEMİ  
//		//--------------------------------------------------------------------------
//	//	//parent tan silince child ı da silindi
//		 session.delete(session.get(H1_Ogrenci.class,111));
//		////child silelim
//		session.delete(session.get(H2_Kitap.class,1003));
//		
		// HQL ile tum kitaplari silelim.
		
//		String hql2 = "DELETE FROM H2_Kitap";
//		int satirSayisi = session.createQuery(hql2).executeUpdate();
//		System.out.println("Silinen Satir Sayisi:"+ satirSayisi);
//		
//	
//		
		
		

		//--------------------------------------------------------------------------
		//  LAZY FETCH VS EAGER FETCH  
		//------------------------------------------------------------------------
		
		/* 
		 *  Hibernate veritabanından verileri cekerken AC GOZLU(EAGER) veya TEMBEL(LAZY) olabilmektedir. 
		 *  EAGER Fetch isleminde bir tablodan veri cekilmesi istendiginde Hibernate o tablo ile iliskili
		 *  Tum tablolari da getirir. 
		 *  
		 *  Eger LAZY fetch islemi kullanilirsa sadece istenilen tablonun verileri getirilir. 
		 * 
		 *  2 yontemin de avantajlari ve dezavatanjlari vardir. Tercih, uygulanin gereksinimlerine gore belirlenir.  
		 * 
		 *  LAZY fetch gereksiz verilerin cekilmemesini saglamak icin ve daha dusuk bellek kullanimi icin daha elvereslidir. 
		 *  Ancak, zamana duyarlı uygulamalarda problem olusturuabilir. iliskili verilerin tek tek veritabnindan getirilmesi
		 *  zaman kayıolarina yol acabilir. 
		 * 
		 *  EAGER fetch ise bazen kullanimayacak veriler bastan pesin pesin getirilmesine yol acabilir.
		 *   
		 *   */
		
 
		System.out.println(session.get(H1_Ogrenci.class, 333));
//		
		tx.commit();
		sf.close();
		session.close();
		
	}

}