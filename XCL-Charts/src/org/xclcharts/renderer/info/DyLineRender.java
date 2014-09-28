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

import org.xclcharts.renderer.plot.PlotArea;

import android.graphics.Canvas;

/**
 * @ClassName DyLineRender
 * @Description 交叉线基类
 * @author XiongChuanLiang<br/>(xcl_168@aliyun.com)
 *  
 */
public class DyLineRender extends DyLine{
	
	PlotArea mArea = null;
	
	public DyLineRender()
	{
		super();
	}
	
	public void setPlotArea(PlotArea area)
	{				
		mArea = area;
	}

		
	// Cross 指定交叉的水平线和垂直线。
	// BackwardDiagonal 从右上到左下的对角线的线条图案。
	// Vertical		垂直线
	// Horizontal 水平线
	private void drawCross(Canvas canvas)
	{	
		//竖线
		drawVertical(canvas);
		//横线
		drawHorizontal(canvas);
	}
	
	private void drawBackwardDiagonal(Canvas canvas)
	{
		//竖线
		float startX = mCenterXY.x;
		float startY = mCenterXY.y;
		float stopX = mCenterXY.x;
		float stopY = mArea.getBottom();
		
		canvas.drawLine(startX, startY, stopX, stopY, getLinePaint());
		//横线
		startX = mArea.getLeft();
		startY = mCenterXY.y;
		stopX = mCenterXY.x;
		stopY = mCenterXY.y;
		canvas.drawLine(startX, startY, stopX, stopY, getLinePaint());
	}
	
	private void drawVertical(Canvas canvas)
	{
		//竖线
		float startX = mCenterXY.x;
		float startY = mArea.getTop();
		float stopX = mCenterXY.x;
		float stopY = mArea.getBottom();
		
		canvas.drawLine(startX, startY, stopX, stopY, getLinePaint());
	}
	
	private void drawHorizontal(Canvas canvas)
	{
		float startX = mArea.getLeft();
		float startY = mCenterXY.y;
		float stopX = mArea.getRight();
		float stopY = mCenterXY.y;
		canvas.drawLine(startX, startY, stopX, stopY, getLinePaint());	
	}
	
	public void renderLine(Canvas canvas) 
	{		
		switch(getDyLineStyle())
		{
		case Cross:
			drawCross(canvas);
			break;
		case BackwardDiagonal:
			drawBackwardDiagonal(canvas);
			break;
		case Vertical:
			drawVertical(canvas);
			break;
		case Horizontal:
			drawHorizontal(canvas);
			break;
		}
	}

}
