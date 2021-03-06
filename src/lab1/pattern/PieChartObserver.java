package lab1.pattern;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class represents a bar chart view of a vector of data. Uses the Observer
 * lab1.pattern.
 */
@SuppressWarnings("serial")
public class PieChartObserver extends JPanel implements Observer {
	/**
	 * Creates a BarChartObserver object
	 *
	 * @param data
	 *            a CourseData object to observe
	 */
	public PieChartObserver(CourseData data) {
		data.attach(this);
		this.courseData = data.getUpdate();
		this.setPreferredSize(new Dimension(2 * LayoutConstants.xOffset
				+ (LayoutConstants.barSpacing + LayoutConstants.barWidth)
				* this.courseData.size(), LayoutConstants.graphHeight + 2
				* LayoutConstants.yOffset));
		this.setBackground(Color.white);
	}

	/**
	 * Paint method
	 * 
	 * @param g
	 *            a Graphics object on which to paint
	 */
	public void paint(Graphics g) {
		super.paint(g);
		int radius = 100;

		//first compute the total number of students
		double total = 0.0;
		for (int i = 0; i < courseData.size(); i++) {
			total += courseData.get(i).getNumOfStudents();
		}
		//if total == 0 nothing to draw
		if (total != 0) {
			double startAngle = 0.0;
			for (int i = 0; i < courseData.size(); i++) {
				double ratio = (courseData.get(i).getNumOfStudents() / total) * 360.0;
				//draw the arc

				g.setColor(LayoutConstants.courseColours[i%LayoutConstants.courseColours.length]);
				g.fillArc(LayoutConstants.xOffset, LayoutConstants.yOffset, 2 * radius, 2 * radius, (int) startAngle, (int) ratio);
				startAngle += ratio;
			}
		}
	}


	/**
	 * Informs this observer that the observed CourseData object has changed
	 * 
	 * @param o
	 *            the observed CourseData object that has changed
	 */
	public void update(Observable o, CourseRecord record) {
		this.setPreferredSize(new Dimension(2 * LayoutConstants.xOffset
				+ (LayoutConstants.barSpacing + LayoutConstants.barWidth)
				* this.courseData.size(), LayoutConstants.graphHeight + 2
				* LayoutConstants.yOffset));
		this.revalidate();
		this.repaint();
	}

	private ArrayList<CourseRecord> courseData;
}