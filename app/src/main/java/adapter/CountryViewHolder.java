package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.liguang.imagesimilar.R;

import java.io.File;

/**
 * Simple view holder for a single text view.
 */
class CountryViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextView;
    private ImageView mImageView;
    private Context context;

    CountryViewHolder(View view, Context context) {
        super(view);
        this.context = context;
        mTextView = (TextView) view.findViewById(R.id.text);
        mImageView = (ImageView) view.findViewById(R.id.image);
    }

    public void bindItem(String text, boolean isheader, String otherInfo) {
        if (!isheader) {
            mTextView.setText(otherInfo+"\n"+text);
            Glide.with(context).load(new File(text)).fitCenter()
                    .into(mImageView);
        }else{
            mTextView.setText(text);
        }
    }

    @Override
    public String toString() {
        return mTextView.getText().toString();
    }

    public void setTextVisible(boolean textVisible) {
        if(textVisible){
            mTextView.setVisibility(View.VISIBLE);
        }else{
            mTextView.setVisibility(View.GONE);
        }

    }
}
