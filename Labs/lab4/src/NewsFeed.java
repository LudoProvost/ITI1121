/* *
 * Use static array for NewsFeed
 * with constant MAX_SIZE
 * */

public class NewsFeed {

    private Post[] messages;
    private int size;
    public static final int MAX_SIZE = 25;

    public NewsFeed() {
        this.messages = new Post[MAX_SIZE];
        this.size = 0;
    }

    public void add(Post message) {
        if (size >= MAX_SIZE) {
            return;
        }
        messages[size++] = message;
    }

    public Post get(int index) {
        return messages[index];
    }

    public int size() {
        return size;
    }

    public void sort() {
        int i, j, argMin;
        Post tmp;
        for (i = 0; i < size - 1; i++) {
            argMin = i;
            for (j = i + 1; j < size(); j++) {
                if (messages[j].compareTo(messages[argMin]) < 0) {
                    argMin = j;
                }
            }

            tmp = messages[argMin];
            messages[argMin] = messages[i];
            messages[i] = tmp;
        }

    }

    public NewsFeed getPhotoPost() {
        NewsFeed photoNewsFeed = new NewsFeed();
        for (int i = 0; i < size; i++) {
            Post post = this.get(i);
            if (post instanceof PhotoPost) {
                photoNewsFeed.add(post);
            }
        }
        return photoNewsFeed;
    }

    public NewsFeed plus(NewsFeed other) {
    	NewsFeed combinationNewsFeed = new NewsFeed();
    	for (NewsFeed newsFeed : new NewsFeed[]{this, other}) {
			for (int i = 0; i < newsFeed.size; i++) {
				combinationNewsFeed.add(newsFeed.get(i));
			}
		}
    	return combinationNewsFeed;
    }

}
