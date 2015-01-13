package kr.ac.uos.sscc.ck.physicslibrary;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuCard#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuCard extends Fragment {
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
	private static final String ARG_PARAM1 = "imgResID";
	private static final String ARG_PARAM2 = "description";

	private int mImgResID;
	private String mDescription;


	/**
	 * Use this factory method to create a new instance of
	 * this fragment using the provided parameters.
	 *
	 * @param param1 Parameter 1.
	 * @param param2 Parameter 2.
	 * @return A new instance of fragment MenuCard.
	 */
	public static MenuCard newInstance(int param1, String param2) {
		MenuCard fragment = new MenuCard();
		Bundle args = new Bundle();
		args.putInt(ARG_PARAM1, param1);
		args.putString(ARG_PARAM2, param2);
		fragment.setArguments(args);
		return fragment;
	}

	public MenuCard() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			mImgResID = getArguments().getInt(ARG_PARAM1);
			mDescription = getArguments().getString(ARG_PARAM2);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		CardView cv = (CardView) inflater.inflate(R.layout.fragment_menu_card, container, false);

		cv.setOnTouchListener(new View.OnTouchListener() {
			private Toast toast = null;

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (toast == null) {
					toast = Toast.makeText(getActivity(), "touched" + mDescription, Toast.LENGTH_SHORT);
					toast.show();
				}

				toast.show();

				return false;
			}
		});

		ImageView iv = (ImageView) cv.findViewById(R.id.card_img);
		iv.setImageResource(mImgResID);

		TextView tv = (TextView) cv.findViewById(R.id.card_description);
		tv.setText(mDescription);

		return cv;
	}
}
