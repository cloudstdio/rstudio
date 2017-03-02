/*
 * ImageResource.java
 *
 * Copyright (C) 2009-17 by RStudio, Inc.
 *
 * Unless you have received this program directly from RStudio pursuant
 * to the terms of a commercial license agreement with RStudio, then
 * this program is licensed to you under the terms of version 3 of the
 * GNU Affero General Public License. This program is distributed WITHOUT
 * ANY EXPRESS OR IMPLIED WARRANTY, INCLUDING THOSE OF NON-INFRINGEMENT,
 * MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. Please refer to the
 * AGPL (http://www.gnu.org/licenses/agpl-3.0.txt) for more details.
 *
 */
package org.rstudio.core.client.command;

import org.rstudio.studio.client.RStudioGinjector;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeUri;

public class ImageResource2x implements ImageResource
{
   public ImageResource2x(ImageResource ref)
   {
      this(ref, null);
   }

   public ImageResource2x(ImageResource ref, ImageResource ref2x)
   {
      ref_ = ref;
      ref2x_ = ref2x;

      if (RStudioGinjector.INSTANCE != null &&
          RStudioGinjector.INSTANCE.getSession() != null &&
          RStudioGinjector.INSTANCE.getSession().getSessionInfo() != null)
         useRetina_ = RStudioGinjector.INSTANCE.getSession().getSessionInfo().getUseRetinaIcons();
   }

   private boolean useRetina()
   {
      return useRetina_ && ref2x_ != null;
   }

   private ImageResource getResource()
   {
      return useRetina() ? ref2x_ : ref_;
   }
   
   @Override
   public String getName()
   {
      return getResource().getName();
   }

   @Override
   public int getHeight()
   {
      return useRetina() ? getResource().getHeight() / 2 : getResource().getHeight();
   }

   @Override
   public int getLeft()
   {
      return getResource().getLeft();
   }

   @Override
   public SafeUri getSafeUri()
   {
      return getResource().getSafeUri();
   }

   @Override
   public int getTop()
   {
      return getResource().getTop();
   }

   @Override
   public String getURL()
   {
      return getResource().getURL();
   }

   @Override
   public int getWidth()
   {
      return useRetina() ? getResource().getWidth() / 2 : getResource().getWidth();
   }

   @Override
   public boolean isAnimated()
   {
      return getResource().isAnimated();
   }
   
   private ImageResource ref_;
   private ImageResource ref2x_;
   private boolean useRetina_ = false;
}