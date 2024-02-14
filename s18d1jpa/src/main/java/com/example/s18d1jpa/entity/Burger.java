package com.example.s18d1jpa.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**Notes:
 * Constructor dışındaki methodları çağırmak için Data anotasyonunu kullandık
 * Arguman olmadan constructor oluşturmak için @NoArgsConstructor anotasyonunu  kullandık.
 * @Entity : bir sınıfın veri tabanındaki tabloya karşılık geldiğini belirtmek için kullandık
 * @Table : bir java sınıfının hangi veri tablosuna karşılık geldiğini belirtmek için kullandık
 * @Column : bir alanın bir veritabanı sütunuyla eşleştirilmesini belirtmek için kullandık
 * Fieldları oluştururken veri tiplerini wrapper classlarla oluşturmamızın nedeni null değeri eklemek için
 * @Column(name= "is_vegan") snake case olarak oluşturmamız gerekiyor
 * Enum değişkenleri @Enumerated anotasyonu ile veri tabanında eşleştirmesini yapıyoruz.
 * spring.jpa.hibernate.ddl-auto = entityler ne ise ona göre tablo oluşturuyor.
 *
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "burger",schema = "fsweb")
public class Burger {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(name = "name")
  private String name;
  @Column(name = "price")
  private double price;
  @Column(name= "is_vegan")
  private boolean isVegan;
  @Enumerated(EnumType.STRING)
  private BreadType breadType;
  @Column(name= "contents")
  private String contents;
}
