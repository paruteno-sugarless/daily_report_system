package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import constants.JpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = JpaConst.TABLE_IIN)
@NamedQueries({
    @NamedQuery(
            name = "getIineCountByReport",
            query = "SELECT COUNT(i) FROM Iine AS i WHERE i.iine_article_id = :iine_article_id"
        ),
    @NamedQuery(
            name = "getIineCountByReportAndUser",
            query = "SELECT COUNT(i) FROM Iine AS i WHERE i.iine_article_id = :iine_article_id  AND i.iine_user = :iine_user"
        )
})

@Getter //全てのクラスフィールドについてgetterを自動生成する(Lombok)
@Setter //全てのクラスフィールドについてsetterを自動生成する(Lombok)
@NoArgsConstructor //引数なしコンストラクタを自動生成する(Lombok)
@AllArgsConstructor //全てのクラスフィールドを引数にもつ引数ありコンストラクタを自動生成する(Lombok)
@Entity
public class Iine {

    /**
     * id
     */
    @Id
    @Column(name = JpaConst.IIN_COL_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * いいねした記事のid
     */
    @Column(name = JpaConst.IIN_COL_ART, nullable = false)
    private Integer iine_article_id;


    /**
     * いいねした人のユーザーコード
     */
    @Column(name = JpaConst.IIN_COL_USE, nullable = false)
    private Integer iine_user;


}