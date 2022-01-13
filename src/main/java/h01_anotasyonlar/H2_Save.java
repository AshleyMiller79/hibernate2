package h01_anotasyonlar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class H2_Save {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H1_Sehir.class);
		
	//cfg.xml dosyasındaki bilgilerle mysql e bağlan                             kalıp class ımızı buraya çağır	
		
		
		SessionFactory sf= con.buildSessionFactory(); // açacağımız alanların parent ı, alan fabrikası
		
		Session session =sf.openSession(); //alan fabrikasından bir yer başlattık
		
		
		// Acilan session icerisinde islemlere baslayabilmek icin Transaction aciyoruz.
				/*Transactionlar ile bir işlem yarıda kaldıysa  veya 
				 * tam olarak tamamlanadıysa tüm adımlar başa alınır
				 * veri ve işlem güvenliği için önemlidir.Kısacası ya hep 
				 * ya hiç prensibine göre çalışır
				 */
		
		Transaction tx=session.beginTransaction();
		
		H1_Sehir sehir1 = new H1_Sehir(37, "Istanbul", 10000000);
		
		session.save(sehir1);
		
		
		
		
	
		
		tx.commit(); //işlemlerin db e hızlı gitmesini sağlar
		
		
		sf.close();
		session.close();
		
		
		
		
		
		

	}

}
