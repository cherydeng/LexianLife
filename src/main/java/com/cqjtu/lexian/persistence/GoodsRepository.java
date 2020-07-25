package com.cqjtu.lexian.persistence;

import com.cqjtu.lexian.domain.Category;
import com.cqjtu.lexian.domain.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * GoodsRepository
 *
 * @author suwen
 */
public interface GoodsRepository extends JpaRepository<Goods, Integer> {
  /**
   * 基于名字的模糊分页查询
   *
   * @param pageable
   * @param name
   * @return
   */
  Page<Goods> findAllByNameLikeAndStatus(String name, int status, Pageable pageable);

  /**
   * @param category
   * @param pageable
   * @param status
   * @return
   */
  Page<Goods> findAllByCategoryAndStatus(Category category, int status, Pageable pageable);

  List<Goods> findAllByCategory(Category category);

  int countByStatus(int status);

  /**
   * @param status
   * @return
   */
  List<Goods> findAllByStatus(int status);
}
