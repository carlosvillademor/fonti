/**
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

package com.carlos.projects.billing.dao.hibernate;

import com.carlos.projects.billing.dao.DocumentDAO;
import com.carlos.projects.billing.domain.Document;
import org.hibernate.SessionFactory;

/**
 * Hibernate implementation of {@link com.carlos.projects.billing.dao.DocumentDAO}
 *
 * @author Carlos Fernandez
 * @date 04-Apr-2012
 */
public class DocumentHibernateDAO extends HibernateDAO<Document, String> implements DocumentDAO {

    public DocumentHibernateDAO() {
    }

    public DocumentHibernateDAO(SessionFactory hibernateSessionFactory) {
        super(hibernateSessionFactory);
    }

}
