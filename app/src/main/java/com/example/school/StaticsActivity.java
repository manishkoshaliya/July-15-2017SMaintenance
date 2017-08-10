package com.example.school;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.example.school.utils.PagerSlidingTabStrip;



public class StaticsActivity extends BaseActivity
{
	private LinearLayout llNewsTipsInstructions;
	private PagerSlidingTabStrip tabs;
	private ViewPager viewPager;
    private FragmentPagerAdapter tabPagerAdapter;
	private int pos = -1;
	@Override
	public void initialize()
	{
		llNewsTipsInstructions = (LinearLayout) inflater.inflate(R.layout.activity_statitics, null);
		llbody1.addView(llNewsTipsInstructions, new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		initializeControls();

	
		viewPager.setCurrentItem(0);
		loadData();
	}

	private void loadData() 
	{
		initPager();
	}
	
	private void initializeControls() 
	{
		tabs      = (PagerSlidingTabStrip) llNewsTipsInstructions.findViewById(R.id.tabs);
		viewPager = (ViewPager)llNewsTipsInstructions.findViewById(R.id.pager);

	}

	
	public void initPager() 
	{

		tabPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) 
		{
		    @Override
		    public int getCount()
		    {
		    	return 2;
		    }

		    @Override
		    public Fragment getItem(int position)
		    {
		    	 if(position == 0)
		    	 {
		    		 StaticsFragment fragment = new StaticsFragment();
		    		 if(pos >= 0)
		    			 fragment.setPos(pos);
					 return fragment;
		    	 }
				 else if(position == 1)
				 {
					 StaticsFragment fragment = new StaticsFragment();
					 return fragment;
				 }

				return null;
		    }
		    
		    @Override  
		    public CharSequence getPageTitle(int position) 
			{  
		        switch (position) 
		        {  
		          case 0:  
		            return "Weekly";
		         case 1:  
		             return "Monthly";

		       }  
		        return null;  
		    }
		    
		};

		viewPager.setAdapter(tabPagerAdapter);
        tabs.setViewPager(viewPager);
        if(getIntent().hasExtra("fromNotification"))
        	viewPager.setCurrentItem(2);
        else
        	viewPager.setCurrentItem(0);
	}
	
	


}
