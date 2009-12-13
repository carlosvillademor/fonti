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
package com.carlos.projects.billing;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Carlos Fernandez
 * @date 6 Oct 2009
 * <p/>
 * Interface to import data from a file to a database
 */
public interface Importer {

    /**
     * @param file file where to import the data from
     * @return number of elements imported
     */
    public Long importData(MultipartFile file);

}