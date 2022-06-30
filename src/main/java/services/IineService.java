package services;

import models.Iine;

/**
 * いいねテーブルの操作に関わる処理を行うクラス
 */
public class IineService extends ServiceBase {

    /**
     * 日報とユーザーの組合せでいいねの件数を取得する
     * @param reportId 日報ID
     * @param iineUserId ユーザーID
     * @return 件数
     */
    public Long getIineCountByReportAndUser(int reportId, int iineUserId) {
        // ユーザーのいいねが既に登録されている件数を取得
        Long count = (Long)em.createNamedQuery("getIineCountByReportAndUser", Long.class)
                .setParameter("iine_article_id", reportId)
                .setParameter("iine_user", iineUserId)
                .getSingleResult();

        return count;
    }

    /**
     * 日報に登録されたいいねの件数を取得する
     * @param reportId 日報ID
     * @return 件数
     */
    public Long getIineCountByReport(int reportId) {
        // 日報に登録されているいいねの件数を取得
        Long count = (Long)em.createNamedQuery("getIineCountByReport", Long.class)
                .setParameter("iine_article_id", reportId)
                .getSingleResult();

        return count;
    }
    /**
     * いいねを1件登録する
     * @param iine いいね
     */
    public void create(Iine iine) {

        em.getTransaction().begin();
        em.persist(iine);
        em.getTransaction().commit();

    }


}