package com.carlos.projects.billing.dao;

import java.io.Serializable;
import java.util.List; /**
 * Fonti is a web application for billing and budgeting
 * Copyright (C) 2009  Carlos Fernandez
 *
 * This file is part of Fonti.
 *
 * Fonti is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Fonti is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * Contains common logic for Data Access Objects.
 *
 * @author Carlos Fernandez
 * @date 03-Dec-2009
 */
public interface DAO<T, ID extends Serializable> {

    public T getById(Class<T> clazz, Serializable id);

    public ID save(T entity);

    public void saveOrUpdate(T entity);

    public void update(T entity);

    public List<T> findAll(String entityName);

}