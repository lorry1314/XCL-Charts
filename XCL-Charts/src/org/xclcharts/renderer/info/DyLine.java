/**
 * Copyright 2014  XCL-Charts
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 	
 * @Project XCL-Charts 
 * @Description Android图表基类库
 * @author XiongChuanLiang<br/>(xcl_168@aliyun.com)
 * @license http://www.apache.org/licenses/  Apache v2 License
 * @version 1.7
 */
package org.xclcharts.renderer.info;

import org.xclcharts.renderer.XEnum;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;

/**
 * @ClassName DyLine
 * @Description 交叉线基类
 * @author XiongChuanLiang<br/>(xcl_168@aliyun.com)
 *  
 */
public class DyLine {
	
	private Paint mPaintLine = null;
	protected PointF mCenterXY = null;
	private XEnum.DyLineStyle mDyLineStyle = XEnum.DyLineStyle.Cross;
	
	private float mOldX = 0.0f,mOldY =0.0f;
	
	public DyLine()
	{
		
	}
	
	public Paint getLinePaint()
	{
		if(null == mPaintLine)
		{
			mPaintLine = new Paint(Paint.ANTI_ALIAS_FLAG);
			//mPaintLine.setStyle(Style.STROKE);
			mPaintLine.setColor(Color.rgb(215, 10, 10)); //50, 165, 238));			
		}
		
		return mPaintLine;
	}

	public void setCenterXY(float x,float y)
	{
		if(null == mCenterXY) mCenterXY = new PointF();
		mCenterXY.x = x;
		mCenterXY.y = y;
	}
	
	public boolean isInvalidate()
	{
		if(null == mCenterXY) return false;
		if(Float.compare(Math.abs(mCenterXY.x - mOldX ) , 5.f ) == 1 
        		|| Float.compare(Math.abs(mCenterXY.y - mOldY), 5.f) == 1)
        {        				          				       
        	mOldX = mCenterXY.x;
        	mOldY = mCenterXY.y;		
        	return true;
        }	
		return false;
	}
	
	
	
	public void setDyLineStyle(XEnum.DyLineStyle style){
		mDyLineStyle = style;
	}
	
	public XEnum.DyLineStyle getDyLineStyle()
	{
		return mDyLineStyle;
	}
	
}
