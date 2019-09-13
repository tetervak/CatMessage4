package ca.javateacher.catmessage4;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class OutputFragment extends Fragment {


  private static final String MESSAGE = "message";
  private String mTextMessage;
  private TextView mMessageView;

  public OutputFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_output, container, false);
    mMessageView = view.findViewById(R.id.message_text);
    if(savedInstanceState != null){
      mTextMessage = savedInstanceState.getString(MESSAGE);
      mMessageView.setText(mTextMessage);
    }else{
      mTextMessage = mMessageView.getText().toString();
    }

    return view;
  }

  public void updateMessage(String text) {
    mTextMessage = text;
    mMessageView.setText(text);
  }

  @Override
  public void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putString(MESSAGE, mTextMessage);
  }

}
