package com.ctrip.model.message.resp;

import java.util.List;

/**
 * ͼ����Ϣ
 * @author Wu Shuai
 *
 */
public class NewsResponseMessage {
	/**
	 * ͼ����Ϣ����������Ϊ8������
	 */
	private int ArticleCount;
	
	/**
	 * ����ͼ����Ϣ��Ϣ��Ĭ�ϵ�һ��itemΪ��ͼ,ע�⣬���ͼ��������8���򽫻�����Ӧ
	 */
	private List<Article> Articles;

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> articles) {
		Articles = articles;
	}
}
